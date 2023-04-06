import request from '@/api/request';
// 首先导入封装好的axios
const api_news = {
  //获取接口信息
  getNews() {
    return request({
      method: 'GET',
      url: '/ai/index',
      // url: 'http://localhost:8888/news',
      params: {
        num: 10,
      }
    });
  },
};
export default api_news;
