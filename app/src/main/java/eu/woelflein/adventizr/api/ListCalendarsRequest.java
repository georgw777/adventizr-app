package eu.woelflein.adventizr.api;

import eu.woelflein.adventizr.calendar.CalendarInfo;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * A request to list all calendars.
 */
public class ListCalendarsRequest extends ApiRequest<List<CalendarInfo>> {

    /**
     * Constructor.
     */
    public ListCalendarsRequest() {
        super("calendars");
    }

    @Override
    public List<CalendarInfo> readResponse(String response) throws ApiResponseException {
        try {
            JSONArray array = new JSONArray(response);
            List<CalendarInfo> calendars = new ArrayList<>(array.length());
            for (int i = 0; i < array.length(); i++) {
                calendars.add(CalendarInfo.fromJson(array.get(i).toString()));
            }
            return calendars;
        } catch (JSONException e) {
            throw new ApiResponseException();
        }
    }
}
