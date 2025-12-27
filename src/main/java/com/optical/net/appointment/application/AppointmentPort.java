package com.optical.net.appointment.application;

import com.optical.net.appointment.domain.AppointmentDomain;

public interface AppointmentPort {
    AppointmentDomain save(AppointmentDomain domain);
}
