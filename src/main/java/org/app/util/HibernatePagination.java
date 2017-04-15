package org.app.util;

/**
 * Created by 31370 on 2017/4/8.
 */
public class HibernatePagination
{
    private Integer beginPage;

    private Integer endPage;

    public HibernatePagination(Integer beginPage, Integer endPage)
    {
        this.beginPage = beginPage;
        this.endPage = endPage;
    }

    public Integer getBeginPage()
    {
        return beginPage;
    }

    public void setBeginPage(Integer beginPage)
    {
        this.beginPage = beginPage;
    }

    public Integer getEndPage()
    {
        return endPage;
    }

    public void setEndPage(Integer endPage)
    {
        this.endPage = endPage;
    }
}
