package com.optical.net.accescontrol.infrastructure.web;

import lombok.Builder;

@Builder
public record PermissionRequest(String name) {
}
