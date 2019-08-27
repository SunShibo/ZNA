package com.zna.server.dao;

import com.zna.server.entity.bo.HistoryBO;

import java.util.List;

public interface HistoryDAO {
    /**
     * 添加发展历史
     * @param historyBO
     */
    void addHistory(HistoryBO historyBO);

    /**
     * 删除发展历史
     * @param id
     */
    void delHistory(int id);

    /**
     * 修改发展历史
     * @param historyBO
     */
    void updateHistory(HistoryBO historyBO);

    /**
     * 查询发展历史
     * @return
     */
    List<HistoryBO> getHistory();
}
