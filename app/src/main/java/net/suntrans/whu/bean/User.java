package net.suntrans.whu.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Looney on 2017/11/16.
 * Des:
 */

@Entity(tableName = "user")
public class User {

    @PrimaryKey
    public int id;
    public int company_id;
    public int area_id;
    public String username;
    public String password;

    public int is_used;//启用状态


}