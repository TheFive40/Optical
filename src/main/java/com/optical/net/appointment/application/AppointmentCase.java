package com.optical.net.appointment.application;

import com.optical.net.appointment.domain.AppointmentDomain;

public interface AppointmentCase {
    AppointmentDomain schedule(AppointmentDomain domain);
}
