package com.linktracker.linktracker.service;

import com.linktracker.linktracker.dto.PasswordDTO;
import com.linktracker.linktracker.dto.SimpleLinkDTO;

public interface LinkService {

    Integer createLink(SimpleLinkDTO link);
    String redirect(Integer linkId, PasswordDTO passwordDto);
    Long getMetrics(Integer linkId);
    void invalidateLink(Integer linkId);
}
