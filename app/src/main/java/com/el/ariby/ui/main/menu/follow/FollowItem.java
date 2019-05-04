package com.el.ariby.ui.main.menu.follow;

import android.graphics.drawable.Drawable;

public class FollowItem {
    private Drawable iconDrawable;
    private String nick;
    private String descStr;

    public Drawable getIconDrawable() {
        return iconDrawable;
    }

    public void setIconDrawable(Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getDescStr() {
        return descStr;
    }

    public void setDescStr(String descStr) {
        this.descStr = descStr;
    }
}
