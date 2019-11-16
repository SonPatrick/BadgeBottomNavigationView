package com.uigitdev.badgebottomnavigationview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.uigitdev.badgebottomnavigationview.adapter.BottomAdapter;
import com.uigitdev.badgebottomnavigationview.model.BottomItem;
import com.uigitdev.badgebottomnavigationview.uigitdev.design.BadgeBottomNavigtion;

public class MainActivity extends AppCompatActivity implements BottomAdapter.BottomItemClickInterface {
    private BadgeBottomNavigtion badgeBottomNavigtion;

    private final int HOME = 0;
    private final int NOTIFICATIONS = 1;
    private final int FRIENDS = 2;
    private final int SETTINGS = 3;
    private final int CART = 4;
    private int selectedId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        badgeBottomNavigtion = new BadgeBottomNavigtion(findViewById(R.id.BottomNavigation), MainActivity.this, MainActivity.this);
        initBottomItems();
    }

    @SuppressLint("ResourceType")
    private void initBottomItems() {
        BottomItem home = new BottomItem(HOME, R.drawable.ic_home, "Home", true);
        BottomItem notifications = new BottomItem(NOTIFICATIONS, R.drawable.ic_notifications, "Notifications", true);
        BottomItem friends = new BottomItem(FRIENDS, R.drawable.ic_people, "Friends", false);
        BottomItem cart = new BottomItem(CART, R.drawable.ic_cart, "Cart", true);
        BottomItem settings = new BottomItem(SETTINGS, R.drawable.ic_settings, "Settings", false);

        badgeBottomNavigtion.addBottomItem(home);
        badgeBottomNavigtion.addBottomItem(notifications);
        badgeBottomNavigtion.addBottomItem(friends);
        badgeBottomNavigtion.addBottomItem(cart);
        badgeBottomNavigtion.addBottomItem(settings);

        badgeBottomNavigtion.apply(selectedId, getString(R.color.selectedColor), getString(R.color.unselectedColor));
        itemSelect(selectedId);
    }

    @Override
    public void itemSelect(int itemId) {
        Toast.makeText(MainActivity.this, "Selected id: " + itemId, Toast.LENGTH_LONG).show();
    }
}
