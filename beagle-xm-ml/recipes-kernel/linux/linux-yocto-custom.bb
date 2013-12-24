# This file was derived from the linux-yocto-custom.bb recipe in
# oe-core.
#
# linux-yocto-custom.bb:
#
#   A yocto-bsp-generated kernel recipe that uses the linux-yocto and
#   oe-core kernel classes to apply a subset of yocto kernel
#   management to git managed kernel repositories.
#
# Warning:
#
#   Building this kernel without providing a defconfig or BSP
#   configuration will result in build or boot errors. This is not a
#   bug.
#
# Notes:
#
#   patches: patches can be merged into to the source git tree itself,
#            added via the SRC_URI, or controlled via a BSP
#            configuration.
#
#   example configuration addition:
#            SRC_URI += "file://smp.cfg"
#   example patch addition:
#            SRC_URI += "file://0001-linux-version-tweak.patch
#   example feature addition:
#            SRC_URI += "file://feature.scc"
#

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;bareclone=1"

SRC_URI += "file://defconfig"

SRC_URI += "file://beagle-xm-ml.scc \
            file://beagle-xm-ml.cfg \
            file://beagle-xm-ml-user-config.cfg \
            file://beagle-xm-ml-user-patches.scc \
           "
SRC_URI += " \
file://patches/audio/0001-ASoC-davinci-evm-Move-sysclk-logic-away-from-evm_hw_.patch \
file://patches/audio/0002-ASoC-davinci-evm-Add-device-tree-binding.patch \
file://patches/audio/0003-ASoC-davinci-mcasp-Add-DMA-register-locations-to-DT.patch \
file://patches/audio/0004-ASoC-davinci-mcasp-Extract-DMA-channels-directly-fro.patch \
file://patches/audio/0005-ASoC-davinci-mcasp-Interrupts-property-to-optional-a.patch \
file://patches/audio/0006-ASoC-davinci-Add-support-for-AM33xx-SoC-Audio.patch \
file://patches/audio/0007-ASoC-davinci-mcasp-Remove-redundant-num-serializer-D.patch \
file://patches/audio/0008-ASoC-davinci-evm-Add-named-clock-reference-to-DT-bin.patch \
file://patches/audio/0009-ASoC-davinci-evm-HDMI-audio-support-for-TDA998x-trou.patch \
file://patches/audio/0010-ASoC-hdmi-codec-Add-devicetree-binding-with-document.patch \
file://patches/audio/0011-ASoC-hdmi-codec-Add-SNDRV_PCM_FMTBIT_32_LE-playback-.patch \
file://patches/audio/0012-ASoC-davinci-HDMI-audio-build-for-AM33XX-and-TDA998x.patch \
file://patches/audio/0013-Audio-McASP-Add-McASP-Device-Tree-Bindings.patch \
file://patches/audio/0014-ASoc-McASP-Lift-Reset-on-CLK-Dividers-when-RX-TX.patch \
file://patches/audio/0015-ASoc-Davinci-EVM-Config-12MHz-CLK-for-AIC3x-Codec.patch \
file://patches/cape-import/0001-capes-import-from-3.8.patch \
file://patches/capemgr/0001-capemgr-Capemgr-makefiles-and-Kconfig-fragments.patch \
file://patches/capemgr/0002-capemgr-Beaglebone-capemanager.patch \
file://patches/capemgr/0003-capemgr-Remove-__devinit-__devexit.patch \
file://patches/capemgr/0004-bone-capemgr-Make-sure-cape-removal-works.patch \
file://patches/capemgr/0005-bone-capemgr-Fix-crash-when-trying-to-remove-non-exi.patch \
file://patches/capemgr/0006-bone-capemgr-Force-a-slot-to-load-unconditionally.patch \
file://patches/capemgr/0007-capemgr-Added-module-param-descriptions.patch \
file://patches/capemgr/0008-capemgr-Implement-disable-overrides-on-the-cmd-line.patch \
file://patches/capemgr/0009-capemgr-Implement-cape-priorities.patch \
file://patches/capemgr/0010-bone-capemgr-Introduce-simple-resource-tracking.patch \
file://patches/capemgr/0011-capemgr-Add-enable_partno-parameter.patch \
file://patches/capes/0001-capemgr-firmware-makefiles-for-DT-objects.patch \
file://patches/cpufreq/0001-ARM-OMAP3-do-not-register-non-dt-OPP-tables-for-devi.patch \
file://patches/cpufreq/0002-ARM-OMAP2-add-missing-lateinit-hook-for-calling-pm-l.patch \
file://patches/cpufreq/0003-ARM-OMAP3-use-cpu0-cpufreq-driver-in-device-tree-sup.patch \
file://patches/cpufreq/0004-ARM-dts-OMAP3-add-clock-nodes-for-CPU.patch \
file://patches/cpufreq/0005-hack-boneblack-enable-1Ghz-operation.patch \
file://patches/deassert-hard-reset/0001-ARM-omap-add-DT-support-for-deasserting-hardware-res.patch \
file://patches/dma-devel/0001-da8xx-config-Enable-MMC-and-FS-options.patch \
file://patches/dma-devel/0002-sound-soc-soc-dmaengine-pcm-Add-support-for-new-DMAE.patch \
file://patches/drm/0001-drm-tilcdc-Add-I2C-HDMI-audio-config-for-tda998x.patch \
file://patches/dtc-fixes/0001-Fix-util_is_printable_string.patch \
file://patches/dtc-fixes/0002-fdtdump-properly-handle-multi-string-properties.patch \
file://patches/dtc-overlays/0001-dtc-Dynamic-symbols-fixup-support.patch \
file://patches/dtc-overlays/0002-dtc-Dynamic-symbols-fixup-support-shipped.patch \
file://patches/dts-fixes/0001-dts-beaglebone-Add-I2C-definitions-for-EEPROMs-capes.patch \
file://patches/dts-fixes/0002-arm-beaglebone-dts-Add-capemanager-to-the-DTS.patch \
file://patches/dts-fixes/0003-OF-Compile-Device-Tree-sources-with-resolve-option.patch \
file://patches/dts-fixes/0004-am335x-bone-enable-HDMI-on-black.patch \
file://patches/general-fixes/0001-add-PM-firmware.patch \
file://patches/general-fixes/0002-ARM-CUSTOM-Build-a-uImage-with-dtb-already-appended.patch \
file://patches/general-fixes/0003-defconfig-add-for-mainline-on-the-beaglebone.patch \
file://patches/i2c-fixes/0001-i2c-EEPROM-In-kernel-memory-accessor-interface.patch \
file://patches/i2c-fixes/0002-grove-i2c-Add-rudimentary-grove-i2c-motor-control-dr.patch \
file://patches/lcdc-fixes/0001-gpu-drm-tilcdc-get-preferred_bpp-value-from-DT.patch \
file://patches/lcdc-fixes/0002-drm-tilcdc-fixing-i2c-slave-initialization-race.patch \
file://patches/lcdc-fixes/0003-drm-tilcdc-Fix-scheduling-while-atomic-from-irq-hand.patch \
file://patches/lcdc-fixes/0004-tilcdc-Slave-panel-settings-read-from-DT-now.patch \
file://patches/mmc-fixes/0001-omap-hsmmc-Correct-usage-of-of_find_node_by_name.patch \
file://patches/mmc-fixes/0002-omap_hsmmc-Add-reset-gpio.patch \
file://patches/net/0001-am33xx-cpsw-default-to-ethernet-hwaddr-from-efuse-if.patch \
file://patches/of-fixes/0001-of-i2c-Export-single-device-registration-method.patch \
file://patches/of-fixes/0002-OF-Clear-detach-flag-on-attach.patch \
file://patches/of-fixes/0003-OF-Introduce-device-tree-node-flag-helpers.patch \
file://patches/of-fixes/0004-OF-export-of_property_notify.patch \
file://patches/of-fixes/0005-OF-Export-all-DT-proc-update-functions.patch \
file://patches/of-fixes/0006-OF-Introduce-utility-helper-functions.patch \
file://patches/of-fixes/0007-OF-Introduce-Device-Tree-resolve-support.patch \
file://patches/of-fixes/0008-OF-Introduce-DT-overlay-support.patch \
file://patches/omap-next-dt/0001-ARM-dts-AM33XX-Add-PMU-support.patch \
file://patches/omap-next-dt/0002-ARM-dts-AM33xx-Correct-gpio-interrupt-cells-property.patch \
file://patches/omap-next-dt/0003-ARM-dts-AM33XX-Add-EDMA-support.patch \
file://patches/omap-next-dt/0004-ARM-dts-AM33XX-Add-SPI-DMA-support.patch \
file://patches/omap-next-dt/0005-ARM-dts-AM33XX-Add-MMC-support-and-documentation.patch \
file://patches/omap-next-dt/0006-ARM-dts-am335x-bone-add-CD-for-mmc1.patch \
file://patches/omap-next-dt/0007-ARM-dts-am335x-boneblack-add-eMMC-DT-entry.patch \
file://patches/omap-next-dt/0008-ARM-dts-am335x-bone-common-switch-mmc1-to-4-bit-mode.patch \
file://patches/omap-next-dt/0009-ARM-dts-am335x-bone-common-add-cpu0-and-mmc1-trigger.patch \
file://patches/omap-next-dt/0010-ARM-dts-AM33XX-use-pinmux-node-defined-in-included-f.patch \
file://patches/omap-next-dt/0011-ARM-dts-AM33XX-don-t-redefine-OCP-bus-and-device-nod.patch \
file://patches/omap-next-dt/0012-ARM-dts-AM33XX-add-ethernet-alias-s-for-am33xx.patch \
file://patches/omap-next-dt/0013-ARM-dts-am335x-boneblack-move-fixed-regulator-to-boa.patch \
file://patches/omap-next-dt/0014-ARM-dts-am335x-bone-common-correct-mux-mode-for-cmd-.patch \
file://patches/pdev-fixes/0001-pdev-Fix-platform-device-resource-linking.patch \
file://patches/pdev-fixes/0002-of-Link-platform-device-resources-properly.patch \
file://patches/pdev-fixes/0003-omap-Properly-handle-resources-for-omap_devices.patch \
file://patches/pdev-fixes/0004-omap-Avoid-crashes-in-the-case-of-hwmod-misconfigura.patch \
file://patches/pinctrl-fixes/0001-pinctrl-pinctrl-single-must-be-initialized-early.patch \
file://patches/reset/0001-reset-Add-driver-for-gpio-controlled-reset-pins.patch \
file://patches/tscadc/0001-Forwarding-changes-from-mfd-next.patch \
file://patches/tscadc/0002-MFD-ti_tscadc-disable-TSC-control.patch \
file://patches/tscadc/0003-IIO-ADC-ti_adc-Fix-1st-sample-read.patch \
file://patches/tscadc/0004-iio-ti_am335x_adc-Added-iio_voltageX_scale.patch \
"

KBRANCH = "linux-3.12.y"

LINUX_VERSION ?= "3.12.5"
LINUX_VERSION_EXTENSION ?= "-custom"


# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2013-12-12 06:38:07 (GMT)
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2013-12-12 06:38:07 (GMT)
# commit	156c7581a8b9b7d9665c63f96e312093736c832e (patch)
# tree		f31d955511e4b344b29925c11e954540b7046244
# parent	012228e9c4841140fc6a3e5da6196b6550890f83 (diff)
# Linux 3.12.5 v3.12.5 linux-3.12.y

SRCREV="156c7581a8b9b7d9665c63f96e312093736c832e"

PR = "r0"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_beagle-xm-ml = "beagle-xm-ml"
