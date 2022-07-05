SUMMARY = "wolfMQTT Client Library"
DESCRIPTION = "wolfMQTT is a client library implementation of the MQTT \
               protocol, written in ANSI C and targeted for embedded, RTOS, \
               and resource-constrained environments. It has been built from \
               the ground up to be multi-platform, space conscious, and \
               extensible. It includes support for the MQTT v5.0 protocol."
HOMEPAGE = "https://www.wolfssl.com/products/wolfmqtt"
BUGTRACKER = "https://github.com/wolfssl/wolfmqtt/issues"
SECTION = "libs"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2"

DEPENDS += "wolfssl"

<<<<<<< HEAD
=======
<<<<<<<< HEAD:recipes-wolfssl/wolfmqtt/wolfmqtt_1.18.0.bb
SRC_URI = "git://github.com/wolfssl/wolfMQTT.git;nobranch=1;protocol=https;rev=91b01f4be412fff883374168aa4da2bd00d2968c"
========
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> a7c22b2 (General Updates for kirkstone recipes versions relating to wolfssl products)
<<<<<<< HEAD:recipes-wolfssl/wolfmqtt/wolfmqtt_1.18.0.bb
SRC_URI = "git://github.com/wolfssl/wolfMQTT.git;protocol=https;tag=v${PV}"
=======
SRC_URI = "git://github.com/wolfssl/wolfMQTT.git;nobranch=1;protocol=https;rev=5d453ac5277327ce8521ce3e7ae7c706b2c931f2 \
           file://0001-fix-have-wolfssl-m4-rule.patch"
>>>>>>> 562f628 (Make changes to support building against kirkstone release.):recipes-wolfssl/wolfmqtt/wolfmqtt_1.10.0.bb
<<<<<<< HEAD
=======
=======
SRC_URI = "git://github.com/wolfssl/wolfMQTT.git;nobranch=1;protocol=https;rev=5d453ac5277327ce8521ce3e7ae7c706b2c931f2"
>>>>>>> 7eaede1 (fix for wolfmqtt build)
=======
SRC_URI = "git://github.com/wolfssl/wolfMQTT.git;nobranch=1;protocol=https;rev=6a1a7f85b4b42e8818a3b3d91760f55ed34d345f"
>>>>>>>> a7c22b2 (General Updates for kirkstone recipes versions relating to wolfssl products):recipes-wolfssl/wolfmqtt/wolfmqtt_1.15.1.bb

>>>>>>> 4d11f71 (update rev commit numbers)
>>>>>>> a7c22b2 (General Updates for kirkstone recipes versions relating to wolfssl products)

S = "${WORKDIR}/git"

inherit autotools pkgconfig

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> a7c22b2 (General Updates for kirkstone recipes versions relating to wolfssl products)
<<<<<<< HEAD:recipes-wolfssl/wolfmqtt/wolfmqtt_1.18.0.bb
EXTRA_OECONF = "--with-libwolfssl-prefix=${COMPONENTS_DIR}/${PACKAGE_ARCH}/wolfssl/usr"
do_configure_prepend() {
=======
<<<<<<< HEAD
=======
=======
EXTRA_OECONF = "--with-libwolfssl-prefix=${COMPONENTS_DIR}/${PACKAGE_ARCH}/wolfssl/usr"

<<<<<<< HEAD
>>>>>>> 7eaede1 (fix for wolfmqtt build)
>>>>>>> a7c22b2 (General Updates for kirkstone recipes versions relating to wolfssl products)
do_configure:prepend() {
>>>>>>> 562f628 (Make changes to support building against kirkstone release.):recipes-wolfssl/wolfmqtt/wolfmqtt_1.10.0.bb
    (cd ${S}; ./autogen.sh; cd -)
=======
python() {
    distro_version = d.getVar('DISTRO_VERSION', True)
    autogen_command = 'cd ${S}; ./autogen.sh'
    if distro_version and (distro_version.startswith('2.') or distro_version.startswith('3.')):
        # For Dunfell and earlier
        d.appendVar('do_configure_prepend', autogen_command)
    else:
        # For Kirkstone and later
        d.appendVar('do_configure:prepend', autogen_command)
>>>>>>> 4a10bb8 (Adding ability to use 2.x, 3.x, and newer versions of Yocto with 1 set of recipes)
}

# Add reproducible build flags
export CFLAGS += ' -g0 -O2 -ffile-prefix-map=${WORKDIR}=.'
export CXXFLAGS += ' -g0 -O2 -ffile-prefix-map=${WORKDIR}=.'
export LDFLAGS += ' -Wl,--build-id=none'

# Ensure consistent locale                                                      
export LC_ALL = "C" 
