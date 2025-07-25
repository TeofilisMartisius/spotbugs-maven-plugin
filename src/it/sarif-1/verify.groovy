/*
 * Copyright 2005-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import groovy.json.JsonSlurper

import java.nio.file.Files
import java.nio.file.Path

Path spotbugSarifFile = basedir.toPath().resolve('target/spotbugsSarif.json')
assert Files.exists(spotbugSarifFile)

println '*******************'
println 'Checking SARIF file'
println '*******************'

Map path = new JsonSlurper().parse(spotbugSarifFile)

List results = path.runs.results[0]
println "BugInstance size is ${results.size()}"

assert results.size() > 0
