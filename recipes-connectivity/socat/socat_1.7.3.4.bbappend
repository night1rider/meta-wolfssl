FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += " file://socat-1.7.3.4.patch"
DEPENDS_remove = "openssl"
DEPENDS += "wolfssl"
EXTRA_OECONF += "--with-wolfssl=${STAGING_EXECPREFIXDIR}"
