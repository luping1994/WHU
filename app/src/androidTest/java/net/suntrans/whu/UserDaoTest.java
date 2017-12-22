/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.suntrans.whu;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import net.suntrans.whu.bean.User;
import net.suntrans.whu.core.db.AppDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test the implementation of {@link net.suntrans.whu.core.db.UserDao}
 */
@RunWith(AndroidJUnit4.class)
public class UserDaoTest {

    private AppDatabase mDatabase;

    @Before
    public void initDb() throws Exception {
        // using an in-memory database because the information stored here disappears when the
        // process is killed
        mDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                AppDatabase.class)
                // allowing main thread queries, just for testing
                .allowMainThreadQueries()
                .build();
    }

    @After
    public void closeDb() throws Exception {
        mDatabase.close();
    }

    @Test
    public void getUsersWhenNoUserInserted() {

    }

    @Test
    public void insertAndGetUser() {
        // When inserting a new user in the data source

    }

    @Test
    public void updateAndGetUser() {
        // Given that we have a user in the data source
      for (int i=1;i<10;i++){
          User aTestUser = ExampleInstrumentedTest.getATestUser(i);
          aTestUser.is_used=1;
          mDatabase.userDao().insertAll(aTestUser);
      }


    }

    @Test
    public void updateUserDao() {

    }
}
