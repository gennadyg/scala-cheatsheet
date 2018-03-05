/*
 * Copyright (c) 2015-2017 Toby Weston
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package s4j.scala.chapter13

import scala.util.control.Breaks._

object Breaks extends App {
  var i: Int = 0
  breakable {
    while (i < 100) {
      System.out.println(i)
      if (i == 10)
        break()
      i += 1
    }
  }

  breakable {
    for (i <- 0 to 100) {
      System.out.println(i)
      if (i == 10)
        break()
    }
  }
}



