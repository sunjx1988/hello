package com.jxsun.mvc;

import com.jxsun.mvc.datatable.PageResult;
import com.jxsun.mvc.datatable.QueryParam;
import com.jxsun.pojo.News;
import com.jxsun.solr.SolrHandler;
import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("solr")
public class SolrController {

    @Autowired
    private SolrHandler solrHandler;

    @RequestMapping("add")
    @ResponseBody
    public RestResult<News> add(@RequestBody News news){
        if(null == news.getId()){
            news.setId(UUID.randomUUID().toString());
        }
        solrHandler.updateOne(news);
        return new RestResult<News>(0, RestResult.SUCCESS ,null);
    }

    @RequestMapping(value = "query", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PageResult<News> query(QueryParam param){
        SolrQuery query = new SolrQuery();

        if(StringUtils.isNotBlank(param.getKw())){
            query.set("q","text:"+param.getKw());
        }else{
            query.set("q","*:*");
        }


        //开启高亮
        query.setHighlight(true);
        //高亮域
        query.addHighlightField("title");
        //前缀
        query.setHighlightSimplePre("<span style='color:red'>");
        //后缀
        query.setHighlightSimplePost("</span>");

        query.setStart(param.getStart());
        query.setRows(param.getLength());

        return solrHandler.query(query,News.class);
    }

    public SolrHandler getSolrHandler() {
        return solrHandler;
    }

    public void setSolrHandler(SolrHandler solrHandler) {
        this.solrHandler = solrHandler;
    }
}
