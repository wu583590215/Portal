package com.sxrcb.portal.dto;

import lombok.Data;

import java.util.List;

/**
 * 树图dto
 */
@Data
public class TreeViewDto {

    private SlotsEntity slots;
    private List<TreeViewDto> children;
    private String title;
    private String key;

    @Data
    public static class SlotsEntity {
        public SlotsEntity(String icon) {
            this.icon = icon;
        }

        private String icon;
    }

}
