import request from "./request";
const api_major =  {
    // 获取专业表信息
    get_major_list() {
        return request({
            method: 'GET',
            url: '/sys/major/list',
        })
    }
}
export default api_major;