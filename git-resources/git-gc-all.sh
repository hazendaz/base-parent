#
# SPDX-License-Identifier: Apache-2.0
# See LICENSE file for details.
#
# Copyright 2011-2026 Hazendaz
#

find ~/Documents/GitHub -name '*.git' -execdir sh -c 'cd {} && git gc' \;
