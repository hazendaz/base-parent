/*
 * SPDX-License-Identifier: Apache-2.0
 * See LICENSE file for details.
 *
 * Copyright 2011-2026 Hazendaz
 */

// Verify the site build succeeded
def buildLog = new File(basedir, 'build.log')
assert buildLog.exists() : 'build.log does not exist'
assert buildLog.text.contains('BUILD SUCCESS') : 'build.log does not contain BUILD SUCCESS'

// Verify the site was generated
def siteDir = new File(basedir, 'target/site')
assert siteDir.exists() : 'target/site directory does not exist'
assert siteDir.isDirectory() : 'target/site is not a directory'
