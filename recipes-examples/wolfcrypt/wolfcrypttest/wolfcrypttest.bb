SUMMARY = "wolfCrypt Test Application"
DESCRIPTION = "wolfCrypt test application used to test crypto algorithm \
               functionality included in the wolfSSL embedded SSL/TLS library."
HOMEPAGE = "https://www.wolfssl.com"
BUGTRACKER = "https://github.com/wolfssl/wolfssl/issues"
SECTION = "x11/applications"

<<<<<<< HEAD
FILESEXTRAPATHS:prepend := "${THISDIR}:"

<<<<<<< HEAD
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://test.c;beginline=1;endline=20;md5=61d63fb8b820bae4d85beb53e7acf340"
=======
=======
>>>>>>> 4a10bb8 (Adding ability to use 2.x, 3.x, and newer versions of Yocto with 1 set of recipes)
LICENSE = "GPL-2.0-only"
<<<<<<< HEAD
LIC_FILES_CHKSUM = "file://test.c;beginline=1;endline=20;md5=6084af2d13b5c768a1afd538bbe2abeb"
>>>>>>> 562f628 (Make changes to support building against kirkstone release.)
=======
LIC_FILES_CHKSUM = "file://test.c;beginline=1;endline=20;md5=61d63fb8b820bae4d85beb53e7acf340"
<<<<<<< HEAD
>>>>>>> 111b8f1 (update lic checksum for new dates)

=======
S = "${WORKDIR}/git/wolfcrypt/test"
>>>>>>> 4a10bb8 (Adding ability to use 2.x, 3.x, and newer versions of Yocto with 1 set of recipes)
DEPENDS += "wolfssl"

<<<<<<< HEAD
<<<<<<< HEAD
WOLFCRYPT_V="5.6.6"
SRC_URI = "git://github.com/wolfssl/wolfssl.git;nobranch=1;protocol=https;tag=v${WOLFCRYPT_V}-stable;"
=======
SRC_URI = "git://github.com/wolfSSL/wolfssl.git;branch=master;protocol=https;rev=9ffa9faecda87a7c0ce7521c83996c65d4e86943"
=======
SRC_URI = "git://github.com/wolfSSL/wolfssl.git;nobranch=1;protocol=https;rev=66596ad9e1d7efa8479656872cf09c9c1870a02e"
>>>>>>> a7c22b2 (General Updates for kirkstone recipes versions relating to wolfssl products)

<<<<<<< HEAD
>>>>>>> 6770211 (Fixed for kirkland and editied README to reflect needed overide commands)
S = "${WORKDIR}/git/wolfcrypt/test"

=======
>>>>>>> 4a10bb8 (Adding ability to use 2.x, 3.x, and newer versions of Yocto with 1 set of recipes)

do_configure[noexec] = "1"
do_compile[noexec] = "1"

WOLFCRYPT_TEST_DIR = "${datadir}/wolfcrypt-test"
WOLFCRYPT_TEST_INSTALL_DIR = "${D}${WOLFCRYPT_TEST_DIR}"
WOLFCRYPT_TEST_README = "README.txt"
WOLFCRYPT_TEST_README_DIR = "${WOLFCRYPT_TEST_INSTALL_DIR}/${WOLFCRYPT_TEST_README}"

python () {
    distro_version = d.getVar('DISTRO_VERSION', True)
    wolfcrypt_test_dir = d.getVar('WOLFCRYPT_TEST_DIR', True)
    wolfcrypt_test_install_dir = d.getVar('WOLFCRYPT_TEST_INSTALL_DIR', True)
    wolfcrypt_test_readme_dir = d.getVar('WOLFCRYPT_TEST_README_DIR', True)

    bb.note("Installing dummy file for wolfCrypt test example")
    installDir = 'install -m 0755 -d "%s"\n' % wolfcrypt_test_install_dir
    makeDummy = 'echo "This is a dummy package" > "%s"\n' % wolfcrypt_test_readme_dir

    d.appendVar('do_install', installDir)
    d.appendVar('do_install', makeDummy)

    pn = d.getVar('PN', True)
    if distro_version and (distro_version.startswith('2.') or distro_version.startswith('3.')):
        files_var_name = 'FILES_' + pn
    else:
        files_var_name = 'FILES:' + pn
    
    current_files = d.getVar(files_var_name, True) or ""
    new_files = current_files + ' ' + wolfcrypt_test_dir + '/*'
    d.setVar(files_var_name, new_files)
}

