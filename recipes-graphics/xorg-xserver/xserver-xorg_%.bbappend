# Copyright (C) 2019, Fuzhou Rockchip Electronics Co., Ltd
# Released under the MIT license (see COPYING.MIT for the terms)

DEPENDS:append = " automake-native autoconf-native util-macros-native font-util-native xtrans-native libxshmfence rockchip-librga"

SRCREV ?= "${AUTOREV}"
SRCREV:firefly-rv1126-jd4 = "ee31265ad72edb0195b4b7c4a7a1fb5593093f3a"
SRC_URI:append = " git://github.com/JeffyCN/xorg-xserver;protocol=https;nobranch=1;branch=${PV}_2022_08_09;"
SRC_URI:remove = "https://www.x.org/releases//individual/xserver/xorg-server-${PV}.tar.bz2"
S = "${WORKDIR}/git"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://20-modesetting.conf"

do_configure:prepend() {
    NOCONFIGURE="yes" ${S}/autogen.sh
}

do_install:append() {
    install -d ${D}${datadir}/X11/xorg.conf.d
    install -m 0755 ${WORKDIR}/20-modesetting.conf \
        ${D}${datadir}/X11/xorg.conf.d/20-modesetting.conf
}
