package config;

public final class Endpoints {

	private Endpoints() {
	}

	public static final String AUTH_LOGIN = "/api/auth/login";
	public static final String AUTH_ME = "/api/auth/me";
	public static final String AUTH_ADMIN_PING = "/api/auth/admin-ping";

	public static final String BUS_SEARCH = "/api/buses";
	public static final String BUS_SEATS = "/api/buses/%s/seats";

	public static final String BOOKINGS = "/api/bookings";
	public static final String BOOKING_PAY = "/api/bookings/%s/pay";
	public static final String BOOKING_CONFIRM = "/api/bookings/%s/confirm";
	public static final String BOOKING_CANCEL = "/api/bookings/%s/cancel";
	public static final String BOOKING_BY_PNR = "/api/bookings/%s";
	public static final String RESET = "/api/reset";
}
