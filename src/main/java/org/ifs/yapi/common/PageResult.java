package org.ifs.yapi.common;

import com.github.pagehelper.Page;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页响应
 *
 * @author wangsong
 * @date 2024/10/07
 */
@Getter
@Setter
public class PageResult<T> {

    private Long total;

    private List<T> rows;

    private PageResult() {

    }

    private PageResult(final Long total, final List<T> rows) {
        this.total = total;
        this.rows = new ArrayList<>();
        this.rows.addAll(rows);
    }

    public static <T> PageResult<T> of(Page<T> page) {
        return new PageResult<T>(page.getTotal(), page.getResult());
    }
    public static <T> PageResult<T> of(List<T> list) {
        return new PageResult<T>(Long.valueOf(list.size()), list);
    }
}
