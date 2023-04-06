// 把axios进行二次封装
// 先导入axios
import axios from 'axios';
/**
 * 默认设置：两种方式，第一种配置项，第二种：使用default.
 * 设置超时时间和跨域是否允许携带凭证（例如携带cookie）
 * 设置baseURL
 */
const request = axios.create({
    timeout: 10000,
    withCredentials: true,
    //baseURL: 'https://apis.tianapi.com',
    baseURL: '/api01',//为处理跨域修改！
    params: {
        key: '3aff15cc32cc9f759fe8221c9045539b',
    },
});
/**
    设置post请求头：告知服务器请求数据格式
    1 默认的格式请求体中的数据会以json字符串的形式发送到后端
      'Content-Type: application/json '
    2 请求体中的数据会以普通表单形式（键值对）发送到后端
      'Content-Type: application/x-www-form-urlencoded'
    3 它会将请求体的数据处理为一条消息，以标签为单元，用分隔符分开。既可以上传键值对，也可以上传文件
      'Content-Type: multipart/form-data'
 */
request.defaults.headers['content-Type'] = 'application/json';
/**
 * 设置请求拦截器：
 *  客户端发送请求：请求拦截器 --> 服务器 -->
 * token校验（JWT）：接收服务器返回的token，存储到vuex/或者本地
 * 存储，每一次请求都要带上token！
 */
request.interceptors.request.use(
    (config) => {
        console.log();
        //预处理一些请求信息，一般会进行token的设置
        const token = localStorage.getItem('token');
        token && (config.headers.Authorization = token);
        return config;
    },
    (error) => {
        console.log(
            '---------------预处理请求异常，将错误抛出！----------------------'
        );
        //预处理请求异常，将错误抛出！
        return Promise.reject(error);
    }
);
/**
 * 响应拦截器：
 * 服务器返回的数据信息 --> 响应拦截器 -->客户端js获取到数据
 */
request.interceptors.response.use(
    (response) => {
        // 筛出返回的主体数据
        return response.data;
    },
    (error) => {
        console.log('---error.response.status=' + error.response.status);
        // 如果服务器给返回结果了！：已经请求到服务器的错误返回
        if (error.response) {
            // 根据不同的状态码提示不同的处理
            switch (error.response.status) {
                case 401: //权限不足，当前请求需要用户验证（一般是未登录）
                    break;
                case 403: //服务器已经理解请求，但是拒绝执行（一般是token过期）
                    localStorage.removeItem('token');
                    break;
                case 404: //请求失败，请求所希望得到的资源没有被发现！
                    break;
                default:
                    console.log('---1111---是否断网');
                    // 判断是否断网
                    if (!window.navigator.onLine) {
                        // 断网处理，跳转到断网页面，可以通过路由去跳转，也可以href跳！
                        console.log('服务器没有返回结果：没有到达服务器！');
                        return;
                    }
                    break;
            }
        }
        console.log("----预处理请求异常，将错误抛出---");
        //预处理请求异常，将错误抛出！
        return Promise.reject(error);
    }
);
export default request;
