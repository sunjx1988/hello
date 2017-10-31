package com.jxsun.solr;

import com.jxsun.pojo.News;
import org.apache.solr.client.solrj.SolrQuery;

import java.util.List;
import java.util.UUID;

public class TestSolrHandler {

    public static void main(String[] args) {
        SolrHandler<News> handler = SolrHandler.instants();

        for(int i = 0 ; i < 100 ; i ++){

            News news = new News();
            news.setId(UUID.randomUUID().toString());
            news.setTitle(new String[]{"这里是标题2222"});
            news.setComments("这里是内容");
            handler.updateOne(news);
        }


//        SolrQuery query = new SolrQuery();
//        query.set("q","title:人民");
//        List<News> list = handler.query(query,News.class);
//
//        for (News n : list){
//            System.out.println(n);
//        }
    }
}

