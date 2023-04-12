import request from '@/api/request';
// 首先导入封装好的axios
const api_news = {
  //获取接口信息
  getNews(pageNum) {
    return request({
      method: 'GET',
      url: '/api01/ai/index',
      // url: 'http://localhost:8888/news',
      params: {
        num: 10,
        page: pageNum,
      }
    });
  },
};
export default api_news;
