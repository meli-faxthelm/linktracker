package com.linktracker.linktracker.repository;

import com.linktracker.linktracker.dto.LinkDTO;
import com.linktracker.linktracker.model.Link;

public interface LinkRepository {

    Integer createLink(Link link);
    String getLink(Integer linkId);
    Long getMetricsByLinkId(Integer linkId);
    void invalidateLinkByLinkId(Integer linkId);

}
