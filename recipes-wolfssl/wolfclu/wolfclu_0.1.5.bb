SUMMARY = "wolfCLU is a command line utility with wolfSSL"
DESCRIPTION = "wolfCLU is a lightweight command line utility written in C and \
               optimized for embedded and RTOS environments."
HOMEPAGE = "https://www.wolfssl.com/products/wolfclu"
BUGTRACKER = "https://github.com/wolfssl/wolfclu/issues"
SECTION = "bin"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PROVIDES += "wolfclu"
RPROVIDES_${PN} = "wolfclu"

<<<<<<< HEAD
<<<<<<< HEAD
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS += "wolfssl"

SRC_URI = "git://github.com/wolfssl/wolfclu.git;nobranch=1;protocol=https;tag=v${PV}-stable;"
=======
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

=======
>>>>>>> 4a10bb8 (Adding ability to use 2.x, 3.x, and newer versions of Yocto with 1 set of recipes)
DEPENDS += "wolfssl"

SRC_URI = "git://github.com/wolfssl/wolfclu.git;nobranch=1;protocol=https;rev=c862879aa92bba201b42ea87f5008f53febf4be3"
>>>>>>> 463caa0 (Updating wolclu and update script)

S = "${WORKDIR}/git"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-wolfssl=${COMPONENTS_DIR}/${PACKAGE_ARCH}/wolfssl/usr"

BBCLASSEXTEND += "native nativesdk"

<<<<<<< HEAD
<<<<<<< HEAD
do_configure_prepend() {
=======
do_configure:prepend() {
>>>>>>> 463caa0 (Updating wolclu and update script)
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


