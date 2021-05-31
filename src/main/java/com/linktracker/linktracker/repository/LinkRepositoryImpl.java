package com.linktracker.linktracker.repository;

import com.linktracker.linktracker.exception.LinkIdNotFoundException;
import com.linktracker.linktracker.model.Identifier;
import com.linktracker.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepositoryImpl implements LinkRepository{

    private static Map<Integer, Link> linkMap = new HashMap<>();
    @Override
    public Integer createLink(Link link) {
        Integer id = Identifier.getNextId();
        linkMap.put(id,link);
        return id;
    }

    @Override
    public String getLink(Integer linkId) {
        Link link = linkMap.get(linkId);
        if (link == null) {
            throw new LinkIdNotFoundException(String.valueOf(linkId));
        }
        linkMap.get(linkId).addCounter();
        return link.getLink();
    }

    @Override
    public Long getMetricsByLinkId(Integer linkId) {
        Link link = linkMap.get(linkId);
        if (link == null) {
            throw new LinkIdNotFoundException(String.valueOf(linkId));
        }
        return link.getCounter();
    }

    @Override
    public void invalidateLinkByLinkId(Integer linkId) {
        linkMap.remove(linkId);
    }
}
