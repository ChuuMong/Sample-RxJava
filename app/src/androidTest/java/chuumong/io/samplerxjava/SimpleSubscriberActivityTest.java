package chuumong.io.samplerxjava;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import chuumong.io.samplerxjava.activity.SimpleSubscriberActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by LeeJongHun on 2016-04-29.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SimpleSubscriberActivityTest {

    private static final String TEXT_STRING = "Nice Hello RxAndroid!!";
    @Rule
    public ActivityTestRule<SimpleSubscriberActivity> activityTestRule = new ActivityTestRule<>(SimpleSubscriberActivity.class);

    @Test
    public void 텍스트가_정상적으로_표현이_되어_지는지() {
        onView(withId(R.id.text)).check(matches(withText(TEXT_STRING)));
    }
}
