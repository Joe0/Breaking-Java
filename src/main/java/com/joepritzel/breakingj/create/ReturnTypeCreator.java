package com.joepritzel.breakingj.create;

import org.objectweb.asm.*;

public class ReturnTypeCreator implements Creator, Opcodes {

	public byte[] create() throws Exception {
		ClassWriter cw = new ClassWriter(0);
		MethodVisitor mv;

		cw.visit(52, ACC_PUBLIC + ACC_SUPER, "com/joepritzel/breakingj/ReturnType", null, "java/lang/Object", null);

		cw.visitSource("ReturnType.java", null);

		{
			mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitLineNumber(3, l0);
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
			mv.visitInsn(RETURN);
			Label l1 = new Label();
			mv.visitLabel(l1);
			mv.visitLocalVariable("this", "Lcom/joepritzel/breakingj/ReturnType;", null, l0, l1, 0);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "returnInt", "(I)B", null, null);
			mv.visitCode();
			Label l0 = new Label();
			mv.visitLabel(l0);
			mv.visitLineNumber(5, l0);
			mv.visitVarInsn(ILOAD, 1);
			mv.visitInsn(IRETURN);
			Label l1 = new Label();
			mv.visitLabel(l1);
			mv.visitLocalVariable("this", "Lcom/joepritzel/breakingj/ReturnType;", null, l0, l1, 0);
			mv.visitLocalVariable("i", "I", null, l0, l1, 1);
			mv.visitMaxs(1, 2);
			mv.visitEnd();
		}
		cw.visitEnd();

		return cw.toByteArray();
	}

	private final String pkg = "com.joepritzel.breakingj";
	private final String simpleName = "ReturnType";

	public String getClassName() {
		return pkg + "." + simpleName;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public String getPackageName() {
		return pkg;
	}

}
