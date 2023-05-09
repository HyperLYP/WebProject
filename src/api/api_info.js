// home模块的请求接口
import request from '@/api/request';
// 首先导入封装好的axios
const api_home = {
  xxx() {
    return request({
      method: 'GET',
      url: '/xxx',
    });
  },
};
export default api_home;
