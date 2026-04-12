/*
 * SPDX-License-Identifier: Apache-2.0
 * See LICENSE file for details.
 *
 * Copyright 2011-2026 Hazendaz
 */

// Verify the basic build succeeded
def buildLog = new File(basedir, 'build.log')
assert buildLog.exists() : 'build.log does not exist'
assert buildLog.text.contains('BUILD SUCCESS') : 'build.log does not contain BUILD SUCCESS'
