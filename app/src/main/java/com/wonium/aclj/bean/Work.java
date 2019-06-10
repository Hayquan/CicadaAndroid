/*
 * Copyright  2018.  wonium
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
 *
 */

package com.wonium.aclj.bean;

import java.util.List;

public class Work {

    private WorkGroup mWorkGroup;
    private List<WorkChild> mWorkChildList;

    public WorkGroup getmWorkGroup() {
        return mWorkGroup;
    }

    public void setmWorkGroup(WorkGroup mWorkGroup) {
        this.mWorkGroup = mWorkGroup;
    }

    public List<WorkChild> getmWorkChildList() {
        return mWorkChildList;
    }

    public void setmWorkChildList(List<WorkChild> mWorkChildList) {
        this.mWorkChildList = mWorkChildList;
    }

}
