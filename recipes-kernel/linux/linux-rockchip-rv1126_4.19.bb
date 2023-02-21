# Copyright (C) 2020, Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-kernel/linux/linux-yocto.inc
require linux-rockchip.inc

inherit freeze-rev local-git

# SRCREV ??= "82957dba3977fd50d4c013e0d359f3203072a0f2"

KBRANCH = "rv1126_rv1109/firefly"
SRCREV ??= "85988bd7b1fc67ac96e868b90f4e676f44c713ae"
SRC_URI = " \
 	git://github.com/iotpi-rockchip/linux-rockchip.git;protocol=https;name=machine;branch=${KBRANCH}; \
 	"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

KERNEL_VERSION_SANITY_SKIP = "1"
LINUX_VERSION ?= "4.19"

SRC_URI:append = " ${@bb.utils.contains('IMAGE_FSTYPES', 'ext4', \
		   'file://${THISDIR}/files/ext4.cfg', \
		   '', \
		   d)}"

do_configure:append() {
    mkdir -p ${B}/drivers/mmc/core/
    cp ${S}/drivers/mmc/core/mmc_blk_data ${B}/drivers/mmc/core/
}
