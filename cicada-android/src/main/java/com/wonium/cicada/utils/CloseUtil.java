/*
 * Copyright (c) 2018.  WoNium,Joy,Lokiwife,JohnDwang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wonium.cicada.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * @ClassName: CloseUtil
 * @Description:
 * @uthor: Ethan
 * @E-mail: wonium@qq.com
 * @Blog: https://blog.wonium.com
 * @CreateDate: 2019/3/20 16:06
 * @UpdateUser: update user
 * @UpdateDate: 2018/11/29 22:56
 * @UpdateDescription: 更新说明
 * @Version:
*/

public  class CloseUtil {
    /**
     * 实例对象
     */
    private static CloseUtil mInstance;
    public static CloseUtil getInstance(){
        if (mInstance==null){
            synchronized (CloseUtil.class){
                if (mInstance==null){
                    mInstance =new CloseUtil();
                }
            }
        }
        return mInstance;
    }
    
    /**
     * 关闭 IO
     *
     * @param closeables closeables
     */
    public  void closeIO(final Closeable... closeables) {
        if (closeables == null) {return;}
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 安静关闭 IO
     *
     * @param closeables closeables
     */
    public  void closeIOQuietly(final Closeable... closeables) {
        if (closeables == null) {return;}
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException ignored) {
                }
            }
        }
    }
}
