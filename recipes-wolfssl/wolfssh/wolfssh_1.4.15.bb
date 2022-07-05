SUMMARY = "wolfSSH Lightweight SSH Library"
DESCRIPTION = "wolfSSH is a lightweight SSHv2 library written in ANSI C and \
               targeted for embedded, RTOS, and resource-constrained \
               environments. wolfSSH supports client and server sides, and \
               includes support for SCP and SFTP."
HOMEPAGE = "https://www.wolfssl.com/products/wolfssh"
BUGTRACKER = "https://github.com/wolfssl/wolfssh/issues"
SECTION = "libs"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSING;md5=2c2d0ee3db6ceba278dd43212ed03733"

DEPENDS += "wolfssl virtual/crypt"

<<<<<<< HEAD:recipes-wolfssl/wolfssh/wolfssh_1.4.15.bb
<<<<<<< HEAD
SRC_URI = "git://github.com/wolfssl/wolfssh.git;nobranch=1;protocol=https;rev=ed97707a9c58d392fdbbbeaa1b3df0faa96d82d2"
=======
SRC_URI = "git://github.com/wolfssl/wolfssh.git;nobranch=1;protocol=https;rev=60a29602e5893fd4e2ca0f4b6e2e05c6324154ed"
>>>>>>> 76bebb9 (Updating wolfssh to newer version)
=======
SRC_URI = "git://github.com/wolfssl/wolfssh.git;nobranch=1;protocol=https;rev=60a29602e5893fd4e2ca0f4b6e2e05c6324154ed"
>>>>>>> a7c22b2 (General Updates for kirkstone recipes versions relating to wolfssl products):recipes-wolfssl/wolfssh/wolfssh_1.4.13.bb

S = "${WORKDIR}/git"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-wolfssl=${COMPONENTS_DIR}/${PACKAGE_ARCH}/wolfssl/usr \
                --enable-certs --enable-sshd --enable-sftp --enable-scp"
CPPFLAGS_append = "-DWOLFSSH_NO_FPKI"

python() {
    distro_version = d.getVar('DISTRO_VERSION', True)
    autogen_command = 'cd ${S}; ./autogen.sh'
    if distro_version and (distro_version.startswith('2.') or distro_version.startswith('3.')):
        # For Dunfell and earlier
        d.appendVar('do_configure_prepend', autogen_command)
    else:
        # For Kirkstone and later
        d.appendVar('do_configure:prepend', autogen_command)
}

<<<<<<< HEAD
<<<<<<< HEAD
=======
# Add reproducible build flags                                                  
CFLAGS:append = " -g0 -O2 -ffile-prefix-map=${WORKDIR}=."                       
CXXFLAGS:append = " -g0 -O2 -ffile-prefix-map=${WORKDIR}=."                     
LDFLAGS:append = " -Wl,--build-id=none"                                         
=======
# Add reproducible build flags
export CFLAGS += ' -g0 -O2 -ffile-prefix-map=${WORKDIR}=.'
export CXXFLAGS += ' -g0 -O2 -ffile-prefix-map=${WORKDIR}=.'
export LDFLAGS += ' -Wl,--build-id=none'
>>>>>>> 4a10bb8 (Adding ability to use 2.x, 3.x, and newer versions of Yocto with 1 set of recipes)

# Ensure consistent locale                                                      
export LC_ALL = "C" 
>>>>>>> 76631a6 (Feature Request from PR76 for kirkstone branch)
