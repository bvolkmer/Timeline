package de.x4fyr.timeline.adapter;

import de.x4fyr.timeline.domain.elements.ExternalElement;
import de.x4fyr.timeline.domain.elements.ScheduledElement;

/**
 * @author Benedikt Volkmer
 *         Created on 11/14/16.
 */
public interface ExternalScheduleAdapter {

    ExternalElement setExternalElementScheduled(ExternalElement element);

    ExternalElement unsetExternalElementScheduled(ScheduledElement element);
}
