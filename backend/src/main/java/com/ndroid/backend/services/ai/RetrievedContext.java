package com.ndroid.backend.services.ai;

import java.util.List;

import com.ndroid.backend.dto.CitationDto;

public record RetrievedContext(
    List<CitationDto> citations,
    String contextText) {
}
