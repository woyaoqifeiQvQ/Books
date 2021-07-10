package com.atguigu.pojo;

import java.util.List;

/**

   @Description 分页模型的对象
   @author woyaoqifeiQvQ
   @create 2021-06-08-17:16
*/
public class Page<T>
{
    public static final Integer PAGE_SIZE = 4; //一页默认显示为4条记录
    public static final Integer PAGE_INIT = 1; //当前页码默认为1

    private Integer pageNo = PAGE_INIT;   //当前页码
    private Integer pageTotal; //总页码
    private Long pageTotalCount; //总纪录数
    private Integer pageSize = PAGE_SIZE; //每页显示数量
    private List<T> items; //当前页数据
    private String url; //分页的请求地址

    public Page()
    {
    }

    public Page(Integer pageNo, Integer pageTotal, Long pageTotalCount, Integer pageSize, List<T> items)
    {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageTotalCount = pageTotalCount;
        this.pageSize = pageSize;
        this.items = items;
    }

    public Integer getPageNo()
    {
        return pageNo;
    }

    public void setPageNo(Integer pageNo)
    {
        if(pageNo < 1)
        {
            pageNo = 1;
        }
        else if(pageNo > pageTotal)
        {
            pageNo = pageTotal;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageTotal()
    {
        return pageTotal;
    }

    public void setPageTotal()
    {
        pageTotal = (int) (pageTotalCount / pageSize);
        if(pageTotalCount % pageSize != 0)
        {
            pageTotal++;
        }
    }

    public Long getPageTotalCount()
    {
        return pageTotalCount;
    }

    public void setPageTotalCount(Long pageTotalCount)
    {
        this.pageTotalCount = pageTotalCount;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public List<T> getItems()
    {
        return items;
    }

    public void setItems(List<T> items)
    {
        this.items = items;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageTotalCount=" + pageTotalCount +
                ", pageSize=" + pageSize +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
