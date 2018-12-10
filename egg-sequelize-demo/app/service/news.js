const Service = require('egg').Service;

class NewsService extends Service {

    async list(page = 1) {
        // read config
        const { serverUrl, pageSize } = this.config.news;
    
        // use build-in http client to GET hacker-news api
        const { data: idList } = await this.ctx.curl(`${serverUrl}//v6/topic/list/1/${page}`, {
          data: {
            orderBy: '"$key"',
            startAt: `"${pageSize * (page - 1)}"`,
            endAt: `"${pageSize * page - 1}"`,
          },
          dataType: 'json',
        });

        Object.keys(idList).map(key => {
            console.log(key);
            
        });
        // console.log(typeof idList);
        // console.log(idList);
        // console.log(idList.data);
        // console.log(idList.data.list);
        // return idList.data.list;
        return idList;
    
        // parallel GET detail
        // const newsList = await Promise.all(
        //   Object.keys(idList).map(key => {
        //     const url = `${serverUrl}/item/${idList[key]}.json`;
        //     return this.ctx.curl(url, { dataType: 'json' });
        //   })
        // );
        // return newsList.map(res => res.data);
      }
    }
    
    module.exports = NewsService;