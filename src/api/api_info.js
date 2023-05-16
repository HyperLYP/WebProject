// home模块的请求接口
import request from '@/api/request';
// 首先导入封装好的axios
const api_info = {
  getStuList(currentPage, pageSize) {
    return request({
      method: 'GET',
      url: '/sys/stu/list',
      params: {
        pageNum:currentPage,
        pageSize:pageSize,
      }
    });
  },
};
export default api_info;
