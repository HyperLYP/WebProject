import request from '@/api/request';
// 首先导入封装好的axios
const api_home = {
  //获取接口信息
  getNotice() {
    return request({
      method: 'GET',
      url: '/api02',
      // url: 'http://localhost:8888/news',
    });
  },
};
export default api_home;
