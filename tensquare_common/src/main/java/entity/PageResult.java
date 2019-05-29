package entity;

import java.util.List;

/**
 * Created by daruan on 2019/5/29.
 */
public class PageResult <T> {
    private long total;
    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public PageResult() {
    }

    public PageResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
