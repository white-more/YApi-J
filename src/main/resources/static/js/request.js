function request(options) {
    return new Promise((resolve, reject) => {
        axios(options)
            .then(response => {
                let data = response.data
                if (data.errcode === 0) {
                    resolve(data.data);
                } else {
                    Vue.prototype.$message({
                        message: data.errmsg,
                        type: 'error'
                    })
                }

            })
            .catch(error => {
                reject(error);
            });
    });
}

async function get(endpoint, query) {
    return await request({
        method: 'get',
        url: endpoint,
        params: query
    });
}

async function post(endpoint, payload) {
    return await request({
        method: 'post',
        url: endpoint,
        data: payload
    });
}