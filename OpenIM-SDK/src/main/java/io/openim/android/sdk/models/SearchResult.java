package io.openim.android.sdk.models;

import java.util.List;

public class SearchResult {
    /**
     * 获取到的总的消息数量
     **/
    private int totalCount;
    private List<SearchResultItem> searchResultItems;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<SearchResultItem> getSearchResultItems() {
        return searchResultItems;
    }

    public void setSearchResultItems(List<SearchResultItem> searchResultItems) {
        this.searchResultItems = searchResultItems;
    }
}
