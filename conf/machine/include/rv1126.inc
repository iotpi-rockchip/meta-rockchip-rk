SOC_FAMILY ?= "rv1126"
require conf/machine/include/arm/armv7a/tune-cortexa7.inc
require conf/machine/include/rockchip-common.inc

PREFERRED_VERSION_linux-rockchip = "4.19%"
LINUXLIBCVERSION = "4.19-custom%"

DEFAULTTUNE ?= "armv7ve-neon-vfpv4"
RK_ISP_VERSION := "1"


