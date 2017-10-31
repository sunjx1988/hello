package com.jxsun.solr;

import com.jxsun.mvc.datatable.PageResult;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.SolrPingResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class SolrHandler<T> {

    private HttpSolrClient client = null;

    private SolrHandler(){
        client = this.getClient();
    }

    public static SolrHandler instants(){
        return new SolrHandler();
    }

    private HttpSolrClient getClient(){
        HttpSolrClient client = new HttpSolrClient(Configuration.getValue(Configuration.SOLR_SERVER_API_KEY));
        client.setConnectionTimeout(new Integer(Configuration.getValue(Configuration.CONNECTION_TIME_OUT_KEY)));
        client.setDefaultMaxConnectionsPerHost(new Integer(Configuration.getValue(Configuration.DEFAULT_MAX_CONNECTIONS_PER_HOST_KEY)));
        client.setMaxTotalConnections(new Integer(Configuration.getValue(Configuration.MAX_TOTAL_CONNECTIONS_KEY)));
        client.setSoTimeout(new Integer(Configuration.getValue(Configuration.SO_TIME_OUT_KEY)));
        return client;
    }

    /**
     * 更新一条索引，如果有id则更新索引，如果没有则新增索引
     */
    public void updateOne(T doc){
        try {
            SolrPingResponse pingResponse = this.client.ping();
            if(pingResponse.getStatus() == 0){
                this.client.addBean(doc);
                this.client.commit();
                System.out.print("add success");
            }else{
                System.out.print("ping fail");
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新多条索引，如果有id则更新索引，如果没有则新增索引
     */
    public void updateList(List<T> list){
        try {
            this.client.addBeans(list);
            this.client.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据ID删除
     */
    public void deleteById(String id){
        try {
            this.client.deleteById(id);
            this.client.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据多个ID删除
     */
    public void deleteByIdList(List<String> ids){
        try {
            this.client.deleteById(ids);
            this.client.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据查询条件删除
     */
    public void deleteByQuery(String queryString){
        try {
            this.client.deleteByQuery(queryString);
            this.client.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询
     */
    public PageResult<T> query(SolrQuery query , Class<T> clz){

        try {
            QueryResponse response = this.client.query(query);
            if(response.getStatus() == 0){
                return new PageResult<T>(0,(int)response.getResults().getNumFound(),  0 ,response.getBeans(clz));
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        }

        return null;
    }

}
