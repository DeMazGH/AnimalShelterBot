package pro.sky.animalshelterbot;

import pro.sky.animalshelterbot.model.Volunteer;

import java.util.Arrays;
import java.util.List;

public class ConstantsTest {

    public static final long LONG_NUM_0 = 0;
    public static final long LONG_NUM_1 = 1;
    public static final long LONG_NUM_2 = 2;
    public static final long LONG_NUM_3 = 3;
    public static final long LONG_NUM_123 = 123;
    public static final long LONG_NUM_1234 = 1234;
    public static final long LONG_NUM_12345 = 12345;

    public static final String NAME_IVAN = "IVAN";
    public static final String NAME_PETR = "PETR";
    public static final String NAME_SEMEN = "SEMEN";

    public static final String PHONE_NUMBER_11111 = "11111";
    public static final String PHONE_NUMBER_22222 = "22222";
    public static final String PHONE_NUMBER_33333 = "33333";

    public static final Volunteer VOLUNTEER_1 = new Volunteer(LONG_NUM_1, NAME_IVAN, LONG_NUM_123, PHONE_NUMBER_11111);
    public static final Volunteer VOLUNTEER_2 = new Volunteer(LONG_NUM_2, NAME_PETR, LONG_NUM_1234, PHONE_NUMBER_22222);

    public static final List<Volunteer> VOLUNTEER_LIST = Arrays.asList(VOLUNTEER_1, VOLUNTEER_2);
}
