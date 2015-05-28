/*
 * Copyright 2013-2015 Tsukasa Kitachi
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

package com.github.kxbmap.configs
package support.scalikejdbc.async

import scalikejdbc.async.AsyncConnectionPoolSettings

case class AsyncDBSettings(url: String,
                           user: String,
                           password: String,
                           asyncPool: AsyncConnectionPoolSettings)

object AsyncDBSettings {

  implicit val asyncDBSettingsConfigs: Configs[AsyncDBSettings] = Configs.configs { c =>
    AsyncDBSettings(
      url = c.getString("url"),
      user = c.getOrElse[String]("user", null),
      password = c.getOrElse[String]("password", null),
      asyncPool = c.getOrElse("asyncPool", AsyncConnectionPoolSettings())
    )
  }
}
