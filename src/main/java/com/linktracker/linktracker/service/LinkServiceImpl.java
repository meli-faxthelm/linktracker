package com.linktracker.linktracker.service;

import com.linktracker.linktracker.dto.PasswordDTO;
import com.linktracker.linktracker.dto.SimpleLinkDTO;
import com.linktracker.linktracker.model.Link;
import com.linktracker.linktracker.repository.LinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements LinkService{

    public LinkServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    LinkRepository linkRepository;

    @Override
    public Integer createLink(SimpleLinkDTO link) {
        Link persistantLink = new Link(link.getLink());
        return linkRepository.createLink(persistantLink);
    }

    @Override
    public String redirect(Integer linkId, PasswordDTO passwordDto) {
        return linkRepository.getLink(linkId);
    }

    @Override
    public Long getMetrics(Integer linkId) {
        return linkRepository.getMetricsByLinkId(linkId);
    }

    @Override
    public void invalidateLink(Integer linkId) {
        linkRepository.invalidateLinkByLinkId(linkId);
    }
}
