package com.example.demo.dto;

import java.util.List;

public class CustomPageResponse<T> {
    private List<T> content;
    private PageInfo page;

    // Constructor
    public CustomPageResponse(List<T> content, PageInfo page) {
        this.content = content;
        this.page = page;
    }

    // Getters and Setters
    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public PageInfo getPage() {
        return page;
    }

    public void setPage(PageInfo page) {
        this.page = page;
    }

    // Inner class for page information
    public static class PageInfo {
        private int size;
        private int number;
        private long totalElements;
        private int totalPages;

        // Constructor
        public PageInfo(int size, int number, long totalElements, int totalPages) {
            this.size = size;
            this.number = number;
            this.totalElements = totalElements;
            this.totalPages = totalPages;
        }

        // Getters and Setters
        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public long getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(long totalElements) {
            this.totalElements = totalElements;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }
    }
}
